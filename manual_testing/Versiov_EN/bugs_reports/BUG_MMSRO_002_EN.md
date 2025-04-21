## BUG_MMSRO_002 | Low Animation Performance

### Issue Description

When hovering over items in the "Realizace" section, there is noticeable lag and the flip animation is not fully rendered.

---

### Priority

**Level:** Medium

> Affects user interface and visual experience, reducing smoothness of interaction.

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

1. Go to: https://modultest1.framer.website/
2. Scroll down to the "Realizace" section
3. Hover and move the cursor between the cards

---

### Expected Behavior

Animations should play smoothly and completely, including the full flip effect.

---

### Actual Behavior

Animations lag, especially while scrolling, and the flip effect is only partially rendered.

---

### Attachments

- [Video showing the issue](https://drive.google.com/file/d/1z4VJtCQh6RSeBq3kWewfSFkCbUOVQEH0/view?usp=sharing)

---

### Suggested Fix

Optimize animation styles (`transform`, `will-change`) and reduce the number of DOM elements in use.

---

### Additional Information

Issue consistently occurs in the specified setup and browsers.
