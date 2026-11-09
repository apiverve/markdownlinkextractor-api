/// Response models for the Markdown Link Extractor API.

/// API Response wrapper.
class MarkdownlinkextractorResponse {
  final String status;
  final dynamic error;
  final MarkdownlinkextractorData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  MarkdownlinkextractorResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory MarkdownlinkextractorResponse.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? MarkdownlinkextractorData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Markdown Link Extractor API.

class MarkdownlinkextractorData {
  num? totalLinks;
  List<MarkdownlinkextractorDataLinksItem>? links;
  MarkdownlinkextractorDataCategories? categories;
  num? markdownLength;

  MarkdownlinkextractorData({
    this.totalLinks,
    this.links,
    this.categories,
    this.markdownLength,
  });

  factory MarkdownlinkextractorData.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorData(
      totalLinks: json['totalLinks'],
      links: (json['links'] as List?)?.map((e) => MarkdownlinkextractorDataLinksItem.fromJson(e)).toList(),
      categories: json['categories'] != null ? MarkdownlinkextractorDataCategories.fromJson(json['categories']) : null,
      markdownLength: json['markdownLength'],
    );
}

class MarkdownlinkextractorDataLinksItem {
  String? text;
  String? url;
  String? type;

  MarkdownlinkextractorDataLinksItem({
    this.text,
    this.url,
    this.type,
  });

  factory MarkdownlinkextractorDataLinksItem.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataLinksItem(
      text: json['text'],
      url: json['url'],
      type: json['type'],
    );
}

class MarkdownlinkextractorDataCategories {
  MarkdownlinkextractorDataCategoriesInternal? internal;
  MarkdownlinkextractorDataCategoriesExternal? external;
  MarkdownlinkextractorDataCategoriesEmail? email;
  MarkdownlinkextractorDataCategoriesOther? other;

  MarkdownlinkextractorDataCategories({
    this.internal,
    this.external,
    this.email,
    this.other,
  });

  factory MarkdownlinkextractorDataCategories.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategories(
      internal: json['internal'] != null ? MarkdownlinkextractorDataCategoriesInternal.fromJson(json['internal']) : null,
      external: json['external'] != null ? MarkdownlinkextractorDataCategoriesExternal.fromJson(json['external']) : null,
      email: json['email'] != null ? MarkdownlinkextractorDataCategoriesEmail.fromJson(json['email']) : null,
      other: json['other'] != null ? MarkdownlinkextractorDataCategoriesOther.fromJson(json['other']) : null,
    );
}

class MarkdownlinkextractorDataCategoriesInternal {
  num? count;
  List<dynamic>? links;

  MarkdownlinkextractorDataCategoriesInternal({
    this.count,
    this.links,
  });

  factory MarkdownlinkextractorDataCategoriesInternal.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategoriesInternal(
      count: json['count'],
      links: (json['links'] as List?)?.cast<dynamic>(),
    );
}

class MarkdownlinkextractorDataCategoriesExternal {
  num? count;
  List<MarkdownlinkextractorDataCategoriesExternalLinksItem>? links;

  MarkdownlinkextractorDataCategoriesExternal({
    this.count,
    this.links,
  });

  factory MarkdownlinkextractorDataCategoriesExternal.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategoriesExternal(
      count: json['count'],
      links: (json['links'] as List?)?.map((e) => MarkdownlinkextractorDataCategoriesExternalLinksItem.fromJson(e)).toList(),
    );
}

class MarkdownlinkextractorDataCategoriesExternalLinksItem {
  String? text;
  String? url;
  String? type;

  MarkdownlinkextractorDataCategoriesExternalLinksItem({
    this.text,
    this.url,
    this.type,
  });

  factory MarkdownlinkextractorDataCategoriesExternalLinksItem.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategoriesExternalLinksItem(
      text: json['text'],
      url: json['url'],
      type: json['type'],
    );
}

class MarkdownlinkextractorDataCategoriesEmail {
  num? count;
  List<dynamic>? links;

  MarkdownlinkextractorDataCategoriesEmail({
    this.count,
    this.links,
  });

  factory MarkdownlinkextractorDataCategoriesEmail.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategoriesEmail(
      count: json['count'],
      links: (json['links'] as List?)?.cast<dynamic>(),
    );
}

class MarkdownlinkextractorDataCategoriesOther {
  num? count;
  List<dynamic>? links;

  MarkdownlinkextractorDataCategoriesOther({
    this.count,
    this.links,
  });

  factory MarkdownlinkextractorDataCategoriesOther.fromJson(Map<String, dynamic> json) => MarkdownlinkextractorDataCategoriesOther(
      count: json['count'],
      links: (json['links'] as List?)?.cast<dynamic>(),
    );
}

class MarkdownlinkextractorRequest {
  String markdown;

  MarkdownlinkextractorRequest({
    required this.markdown,
  });

  Map<String, dynamic> toJson() => {
      'markdown': markdown,
    };
}
