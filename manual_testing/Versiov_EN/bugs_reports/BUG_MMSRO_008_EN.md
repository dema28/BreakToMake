## BUG_MMSRO_008 | Video Not Playing

### Issue Description

In the "Galerie" → "Doprava" album, the video does not play — a placeholder appears and clicking it results in an error.

---

### Priority

**Level:** Medium

> Affects the visual experience and user interaction with the site.

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

1. Go to: https://modultest1.framer.website
2. Open the "Galerie" tab
3. Select the "Doprava" album
4. Scroll to the bottom of the page
5. Click on the video

---

### Expected Behavior

Video loads properly, shows a preview and starts playing upon click.

---

### Actual Behavior

A placeholder is shown, and an error occurs when attempting to play the video.

---

### Attachments

- [Screenshot of the error](https://drive.google.com/file/d/1hNUMbEZ9hJttsQrJjx0gV9q4TGssnSsQ/view?usp=sharing)
- [Screenshot of the placeholder](https://drive.google.com/file/d/1dRN1MHB70JDea4ifx1TIWAsWUlXm3hz8/view?usp=sharing)

---

### Suggested Fix

Check the video link, file format, and hosting. Ensure compatibility across browsers and devices.

---

### Additional Information

Issue consistently occurs in the specified configuration and tab.
