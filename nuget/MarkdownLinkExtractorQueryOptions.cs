using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.MarkdownLinkExtractor
{
    /// <summary>
    /// Query options for the Markdown Link Extractor API
    /// </summary>
    public class MarkdownLinkExtractorQueryOptions
    {
        /// <summary>
        /// Markdown text to parse (max 100,000 characters)
        /// Example: # Title\n\n[Link](https://example.com)
        /// </summary>
        [JsonProperty("markdown")]
        public string Markdown { get; set; }
    }
}
