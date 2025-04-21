## BUG_MMSRO_003 | Photo Misalignment in Mobile Gallery

### Issue Description

On mobile devices, the photo gallery appears misaligned — images are not centered.

---

### Priority

**Level:** Medium

> Affects visual aesthetics and gives an impression of a poorly designed interface.

---

### Environment

| Parameter        | Value           |
| ---------------- | --------------- |
| Device           | Mobile          |
| Operating System | Android / iOS   |
| Browser          | Chrome / Safari |
| System Version   | 10QKQ / 18.3.2  |
| Code Version     | N/A — UI test   |

---

### Steps to Reproduce

1. Open https://modultest1.framer.website on a mobile device
2. Navigate to the "Galerie" section
3. Open any album
4. Observe image alignment

---

### Expected Behavior

All images are centered and properly aligned within the view area.

---

### Actual Behavior

Some images are shifted to the left, disrupting the visual layout.

---

### Attachments

- [Screenshot (Android)](https://drive.google.com/file/d/1SDp315puWxDWIlRe8uuUEl_imabD9pCz/view?usp=sharing)
- [Screenshot (iPhone)](https://drive.google.com/file/d/1QvjR-fYATIJTr8PruKTFBxe72sbs7y-y/view?usp=sharing)

---

### Suggested Fix

Adjust mobile CSS styles to ensure proper centering of gallery content.

---

### Additional Information

The issue is consistently reproducible in the given configuration and browsers.
