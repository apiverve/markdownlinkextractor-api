declare module '@apiverve/markdownlinkextractor' {
  export interface markdownlinkextractorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface markdownlinkextractorResponse {
    status: string;
    error: string | null;
    data: MarkdownLinkExtractorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface MarkdownLinkExtractorData {
      totalLinks:     number | null;
      links:          Link[];
      categories:     Categories;
      markdownLength: number | null;
  }
  
  interface Categories {
      internal: Email;
      external: Email;
      email:    Email;
      other:    Email;
  }
  
  interface Email {
      count: number | null;
      links: Link[];
  }
  
  interface Link {
      text:       null | string;
      url:        null | string;
      type:       null | string;
      reference?: null | string;
  }

  export default class markdownlinkextractorWrapper {
    constructor(options: markdownlinkextractorOptions);

    execute(callback: (error: any, data: markdownlinkextractorResponse | null) => void): Promise<markdownlinkextractorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: markdownlinkextractorResponse | null) => void): Promise<markdownlinkextractorResponse>;
    execute(query?: Record<string, any>): Promise<markdownlinkextractorResponse>;
  }
}
