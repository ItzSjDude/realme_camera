package com.oplus.camera.sticker.p165a;

/* compiled from: StickerViewHelper.java */
/* renamed from: com.oplus.camera.sticker.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class StickerViewHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16771a() {
        return "CREATE VIEW IF NOT EXISTS sticker_view AS SELECT sticker_item._id, uuid, name, file_url, file_content_uri, file_md5, thumbnail_url, thumbnail_file_uri, thumbnail_md5, version, protocol_version, logo_url, logo_file_uri, logo_md5, has_music, sticker_item.position, sticker_item.category_id, category_position, download_uuid, download_state, download_time, need_update, is_build_in, attribute, sticker_item.is_new, sticker_item.request_time, sticker_item.is_valid, sticker_category.category_name, sticker_category.icon_url AS category_icon_url, sticker_category.icon_path AS category_icon_path, sticker_category.icon_file_uri AS category_icon_file_uri, sticker_category.icon_md5 AS category_icon_md5, sticker_category.icon_highlight_url AS category_highlight_icon_url, sticker_category.icon_highlight_path AS category_highlight_icon_path, sticker_category.icon_highlight_file_uri AS category_highlight_icon_file_uri, sticker_category.icon_highlight_md5 AS category_highlight_icon_md5, sticker_category.is_new AS category_is_new, sticker_category.request_time AS category_request_time, sticker_category.is_valid AS category_is_valid FROM sticker_item, sticker_category WHERE sticker_item.category_id = sticker_category.readable_id;";
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m16772b() {
        return "CREATE VIEW IF NOT EXISTS sticker_view AS SELECT sticker_item._id, uuid, name, file_url, file_content_uri, file_md5, thumbnail_url, thumbnail_file_uri, thumbnail_md5, version, protocol_version, logo_url, logo_file_uri, logo_md5, has_music, material_type, sticker_item.position, sticker_item.category_id, category_position, download_uuid, download_state, download_time, need_update, is_build_in, attribute, sticker_item.is_new, sticker_item.request_time, sticker_item.is_valid, sticker_category.category_name, sticker_category.icon_url AS category_icon_url, sticker_category.icon_path AS category_icon_path, sticker_category.icon_file_uri AS category_icon_file_uri, sticker_category.icon_md5 AS category_icon_md5, sticker_category.icon_highlight_url AS category_highlight_icon_url, sticker_category.icon_highlight_path AS category_highlight_icon_path, sticker_category.icon_highlight_file_uri AS category_highlight_icon_file_uri, sticker_category.icon_highlight_md5 AS category_highlight_icon_md5, sticker_category.is_new AS category_is_new, sticker_category.request_time AS category_request_time, sticker_category.is_valid AS category_is_valid FROM sticker_item, sticker_category WHERE sticker_item.category_id = sticker_category.readable_id;";
    }
}
