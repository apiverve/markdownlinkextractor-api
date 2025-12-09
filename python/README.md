Markdown Link Extractor API
============

Markdown Link Extractor parses markdown documents and extracts all links including inline, reference, autolinks, and image URLs.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Markdown Link Extractor API](https://apiverve.com/marketplace/api/markdownlinkextractor)

---

## Installation
	pip install apiverve-markdownlinkextractor

---

## Configuration

Before using the markdownlinkextractor API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Markdown Link Extractor API documentation is found here: [https://docs.apiverve.com/api/markdownlinkextractor](https://docs.apiverve.com/api/markdownlinkextractor).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_markdownlinkextractor.apiClient import MarkdownlinkextractorAPIClient

# Initialize the client with your APIVerve API key
api = MarkdownlinkextractorAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "markdown": "# Sample Document\n\nCheck out [this link](https://example.com) and [another one](https://test.com).\n\n![Image](https://example.com/image.png)\n\nVisit <https://autolink.com> or just https://bare-url.com\n\n[Reference link][ref1]\n\n[ref1]: https://reference.com" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "totalLinks": 6,
    "links": [
      {
        "text": "this link",
        "url": "https://example.com",
        "type": "inline"
      },
      {
        "text": "another one",
        "url": "https://test.com",
        "type": "inline"
      },
      {
        "text": "Image",
        "url": "https://example.com/image.png",
        "type": "inline"
      },
      {
        "text": "Reference link",
        "url": "https://reference.com",
        "type": "reference",
        "reference": "ref1"
      },
      {
        "text": "https://autolink.com",
        "url": "https://autolink.com",
        "type": "autolink"
      },
      {
        "text": "https://bare-url.com",
        "url": "https://bare-url.com",
        "type": "bare"
      }
    ],
    "categories": {
      "internal": {
        "count": 0,
        "links": []
      },
      "external": {
        "count": 6,
        "links": [
          {
            "text": "this link",
            "url": "https://example.com",
            "type": "inline"
          },
          {
            "text": "another one",
            "url": "https://test.com",
            "type": "inline"
          },
          {
            "text": "Image",
            "url": "https://example.com/image.png",
            "type": "inline"
          },
          {
            "text": "Reference link",
            "url": "https://reference.com",
            "type": "reference",
            "reference": "ref1"
          },
          {
            "text": "https://autolink.com",
            "url": "https://autolink.com",
            "type": "autolink"
          },
          {
            "text": "https://bare-url.com",
            "url": "https://bare-url.com",
            "type": "bare"
          }
        ]
      },
      "email": {
        "count": 0,
        "links": []
      },
      "other": {
        "count": 0,
        "links": []
      }
    },
    "markdownLength": 253
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.