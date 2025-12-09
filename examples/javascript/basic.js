/**
 * Markdown Link Extractor API - Basic Usage Example
 *
 * This example demonstrates the basic usage of the Markdown Link Extractor API.
 * API Documentation: https://docs.apiverve.com/ref/markdownlinkextractor
 */

const API_KEY = process.env.APIVERVE_API_KEY || 'YOUR_API_KEY_HERE';
const API_URL = 'https://api.apiverve.com/v1/markdownlinkextractor';

/**
 * Make a POST request to the Markdown Link Extractor API
 */
async function callMarkdownLinkExtractorAPI() {
  try {
    // Request body
    const requestBody &#x3D; {
    &quot;markdown&quot;: &quot;# Sample Document\n\nCheck out [this link](https://example.com) and [another one](https://test.com).\n\n![Image](https://example.com/image.png)\n\nVisit &lt;https://autolink.com&gt; or just https://bare-url.com\n\n[Reference link][ref1]\n\n[ref1]: https://reference.com&quot;
};

    const response = await fetch(API_URL, {
      method: 'POST',
      headers: {
        'x-api-key': API_KEY,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestBody)
    });

    // Check if response is successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();

    // Check API response status
    if (data.status === 'ok') {
      console.log('✓ Success!');
      console.log('Response data:', data.data);
      return data.data;
    } else {
      console.error('✗ API Error:', data.error || 'Unknown error');
      return null;
    }

  } catch (error) {
    console.error('✗ Request failed:', error.message);
    return null;
  }
}

// Run the example
callMarkdownLinkExtractorAPI()
  .then(result => {
    if (result) {
      console.log('\n📊 Final Result:');
      console.log(JSON.stringify(result, null, 2));
    }
  });
