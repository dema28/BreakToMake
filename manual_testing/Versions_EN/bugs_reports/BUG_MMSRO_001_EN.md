## BUG_MMSRO_001 | Incorrect Logo Display

### Issue Description

On both the homepage and all internal pages, the logo in the header is displayed incorrectly — the back part of the image is missing.

---

### Priority

**Level:** High

> The logo is a key element of the company's branding. Its incorrect display affects brand recognition.

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

1. Open any of the listed browsers
2. Go to: https://modultest1.framer.website/
3. Observe the logo in the top-left corner of the page

---

### Expected Behavior

The logo should be displayed fully and correctly, according to the design requirements and branding guide.

---

### Actual Behavior

The back part of the logo is missing, and it looks cut off visually.

---

### Attachments

- [Correct logo display](https://drive.google.com/file/d/1IxXWo8ez2Lx3oTZRMJpN4GpCHWuXMJ5M/view?usp=sharing)
- [Incorrect logo display](https://drive.google.com/file/d/112GIr3R9XnxOwyk9q2aYT1OppV3Qi3Mv/view?usp=sharing)

---

### Suggested Fix

Check and correct the image path for the logo in the page code. Ensure the file is fully loaded and matches the visual design.

---

### Additional Information

This issue occurs on every page and across all tested browsers.
