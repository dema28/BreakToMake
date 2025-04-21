## BUG_MMSRO_005 | Non-clickable Photos in Gallery

### Issue Description

Photos in the "Galerie" section are not clickable — clicking an image does not trigger zoom or open a modal view.

---

### Priority

**Level:** Low

> Minor issue, but affects user experience and interactivity.

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

1. Go to https://modultest1.framer.website
2. Open the "Galerie" tab
3. Select any album
4. Click on an image

---

### Expected Behavior

The image enlarges or opens in a modal/lightbox view.

---

### Actual Behavior

Clicking on an image does nothing.

---

### Attachments

_(none provided)_

---

### Suggested Fix

Implement image click interaction to zoom or open in a modal window.

---

### Additional Information

Issue consistently reproduced across tested browsers.
