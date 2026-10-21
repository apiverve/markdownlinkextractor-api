# Markdown Link Extractor API - Ruby Gem

Markdown Link Extractor parses markdown documents and extracts all links including inline, reference, autolinks, and image URLs.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_markdownlinkextractor'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_markdownlinkextractor
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_markdownlinkextractor'

# Initialize the client
client = APIVerve::Markdownlinkextractor::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ markdown: "# Sample Document

Check out [this link](https://example.com) and [another one](https://test.com).

![Image](https://example.com/image.png)

Visit <https://autolink.com> or just https://bare-url.com

[Reference link][ref1]

[ref1]: https://reference.com" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ markdown: "# Sample Document

Check out [this link](https://example.com) and [another one](https://test.com).

![Image](https://example.com/image.png)

Visit <https://autolink.com> or just https://bare-url.com

[Reference link][ref1]

[ref1]: https://reference.com" })
  puts response["data"]
rescue APIVerve::Markdownlinkextractor::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Markdownlinkextractor::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Markdownlinkextractor::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/markdownlinkextractor?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/markdownlinkextractor?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/markdownlinkextractor?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
