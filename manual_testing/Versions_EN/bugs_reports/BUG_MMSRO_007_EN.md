## BUG_MMSRO_007 | Image Positioned Outside Its Container

### Issue Description

On the homepage, in the "O nas" section, the image is placed outside its designated container, breaking the intended layout.

---

### Priority

**Level:** Medium

> Affects visual layout and structure of the page.

---

### Environment

| Parameter        | Value                                                                                 |
| ---------------- | ------------------------------------------------------------------------------------- |
| Device           | PC                                                                                    |
| Operating System | Windows 11 Pro                                                                        |
| Browsers         | Chrome 134.0.6998.166 (64-bit), Firefox 136.0.2 (64-bit), Edge 134.0.3124.85 (64-bit) |
| System Version   | 64-bit                                                                                |

---

### Steps to Reproduce

1. Open https://modultest1.framer.website
2. Scroll to the "O nas" section

---

### Expected Behavior

The image is displayed correctly inside the container without breaking the layout.

---

### Actual Behavior

The image is rendered outside of its container, disrupting the layout.

---

### Attachments

- [Screenshot showing the issue](https://drive.google.com/file/d/1AUVzm6nW-rPyXGoFHHu3CcjKFGVJ56vl/view?usp=sharing)

---

### Suggested Fix

Adjust HTML/CSS structure to ensure the image remains inside its designated container.

---

### Additional Information

Issue is consistently observed in the specified environment and browsers.
