# Thymeleaf-Template

Dự án mẫu cho môn **Lập trình Java nâng cao** minh họa:
- **Thymeleaf Template** với `layout.html` và các **fragments** (`_head`, `_header`, `_footer`)
- Trang **Home**, **About**, **Products**: list, create/edit (form + **Bean Validation**), detail, delete
- **Error pages** (404, error)
- **DevTools** reload nhanh khi chỉnh sửa

## Chạy nhanh

```bash
mvn spring-boot:run
```

Mặc định http://localhost:8080

## Các đường dẫn chính
- `/` – Trang chủ
- `/about` – Giới thiệu
- `/products` – Danh sách sản phẩm
- `/products/new` – Tạo sản phẩm
- `/products/{id}` – Chi tiết
- `/products/{id}/edit` – Sửa
- POST `/products/{id}/delete` – Xóa

## Ghi chú
- Dự án **in-memory** (không DB) để tập trung vào Thymeleaf Template.
- Bật `spring.thymeleaf.cache=false` giúp phát triển template nhanh.

---
