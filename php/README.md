# Markdown Link Extractor API - PHP Package

Markdown Link Extractor parses markdown documents and extracts all links including inline, reference, autolinks, and image URLs.

## Installation

Install via Composer:

```bash
composer require apiverve/markdownlinkextractor
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Markdownlinkextractor\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['markdown' => '# Sample Document

Check out [this link](https://example.com) and [another one](https://test.com).

![Image](https://example.com/image.png)

Visit <https://autolink.com> or just https://bare-url.com

[Reference link][ref1]

[ref1]: https://reference.com']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Markdownlinkextractor\Client;
use APIVerve\Markdownlinkextractor\Exceptions\APIException;
use APIVerve\Markdownlinkextractor\Exceptions\ValidationException;

try {
    $response = $client->execute(['markdown' => '# Sample Document

Check out [this link](https://example.com) and [another one](https://test.com).

![Image](https://example.com/image.png)

Visit <https://autolink.com> or just https://bare-url.com

[Reference link][ref1]

[ref1]: https://reference.com']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/markdownlinkextractor?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/markdownlinkextractor?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/markdownlinkextractor?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
