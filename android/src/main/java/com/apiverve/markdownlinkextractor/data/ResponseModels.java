// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     MarkdownLinkExtractorData data = Converter.fromJsonString(jsonString);

package com.apiverve.markdownlinkextractor.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static MarkdownLinkExtractorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(MarkdownLinkExtractorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(MarkdownLinkExtractorData.class);
        writer = mapper.writerFor(MarkdownLinkExtractorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// MarkdownLinkExtractorData.java

package com.apiverve.markdownlinkextractor.data;

import com.fasterxml.jackson.annotation.*;

public class MarkdownLinkExtractorData {
    private long totalLinks;
    private Link[] links;
    private Categories categories;
    private long markdownLength;

    @JsonProperty("totalLinks")
    public long getTotalLinks() { return totalLinks; }
    @JsonProperty("totalLinks")
    public void setTotalLinks(long value) { this.totalLinks = value; }

    @JsonProperty("links")
    public Link[] getLinks() { return links; }
    @JsonProperty("links")
    public void setLinks(Link[] value) { this.links = value; }

    @JsonProperty("categories")
    public Categories getCategories() { return categories; }
    @JsonProperty("categories")
    public void setCategories(Categories value) { this.categories = value; }

    @JsonProperty("markdownLength")
    public long getMarkdownLength() { return markdownLength; }
    @JsonProperty("markdownLength")
    public void setMarkdownLength(long value) { this.markdownLength = value; }
}

// Categories.java

package com.apiverve.markdownlinkextractor.data;

import com.fasterxml.jackson.annotation.*;

public class Categories {
    private Email internal;
    private Email external;
    private Email email;
    private Email other;

    @JsonProperty("internal")
    public Email getInternal() { return internal; }
    @JsonProperty("internal")
    public void setInternal(Email value) { this.internal = value; }

    @JsonProperty("external")
    public Email getExternal() { return external; }
    @JsonProperty("external")
    public void setExternal(Email value) { this.external = value; }

    @JsonProperty("email")
    public Email getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(Email value) { this.email = value; }

    @JsonProperty("other")
    public Email getOther() { return other; }
    @JsonProperty("other")
    public void setOther(Email value) { this.other = value; }
}

// Email.java

package com.apiverve.markdownlinkextractor.data;

import com.fasterxml.jackson.annotation.*;

public class Email {
    private long count;
    private Link[] links;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("links")
    public Link[] getLinks() { return links; }
    @JsonProperty("links")
    public void setLinks(Link[] value) { this.links = value; }
}

// Link.java

package com.apiverve.markdownlinkextractor.data;

import com.fasterxml.jackson.annotation.*;

public class Link {
    private String text;
    private String url;
    private String type;
    private String reference;

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("reference")
    public String getReference() { return reference; }
    @JsonProperty("reference")
    public void setReference(String value) { this.reference = value; }
}