/**
 * Basic Example - Markdown Link Extractor API
 *
 * This example demonstrates how to use the Markdown Link Extractor API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const markdownlinkextractorAPI = require('../index.js');

// Initialize the API client
const api = new markdownlinkextractorAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "markdown": "# Sample Document\n\nCheck out [this link](https://example.com) and [another one](https://test.com).\n\n![Image](https://example.com/image.png)\n\nVisit <https://autolink.com> or just https://bare-url.com\n\n[Reference link][ref1]\n\n[ref1]: https://reference.com"
};

// Make the API request using callback
console.log('Making request to Markdown Link Extractor API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
