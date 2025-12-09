declare module '@apiverve/markdownlinkextractor' {
  export interface markdownlinkextractorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface markdownlinkextractorResponse {
    status: string;
    error: string | null;
    data: MarkdownLinkExtractorData;
    code?: number;
  }


  interface MarkdownLinkExtractorData {
      totalLinks:     number;
      links:          Link[];
      categories:     Categories;
      markdownLength: number;
  }
  
  interface Categories {
      internal: Email;
      external: Email;
      email:    Email;
      other:    Email;
  }
  
  interface Email {
      count: number;
      links: Link[];
  }
  
  interface Link {
      text:       string;
      url:        string;
      type:       string;
      reference?: string;
  }

  export default class markdownlinkextractorWrapper {
    constructor(options: markdownlinkextractorOptions);

    execute(callback: (error: any, data: markdownlinkextractorResponse | null) => void): Promise<markdownlinkextractorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: markdownlinkextractorResponse | null) => void): Promise<markdownlinkextractorResponse>;
    execute(query?: Record<string, any>): Promise<markdownlinkextractorResponse>;
  }
}
