## BUG_MMSRO_004 | No Visual Feedback on Tab Buttons

### Issue Description

There is no visual feedback when switching between tabs. The user cannot tell which tab is currently active.

---

### Priority

**Level:** Medium

> Affects navigation clarity and overall interface usability.

---

### Environment

| Parameter        | Value                                                                   |
| ---------------- | ----------------------------------------------------------------------- |
| Device           | PC                                                                      |
| Operating System | Windows 11 Pro                                                          |
| Browsers         | Chrome 134.0.6998.166, Firefox 136.0.2, Edge 134.0.3124.85 (all 64-bit) |
| System Version   | 64-bit                                                                  |

---

### Steps to Reproduce

1. Open https://modultest1.framer.website
2. Click on any tab in the top navigation

---

### Expected Behavior

The button should visually change when active — color, shadow, highlight, or animation.

---

### Actual Behavior

There is no visible feedback — the user cannot tell which tab is currently selected.

---

### Attachments

- [Video showing the issue](https://drive.google.com/file/d/199pqW2gBiNDZdMg8JVFJEb3FpiRZyf16/view?usp=sharing)

---

### Suggested Fix

Add styling for the active state and visual feedback when clicking a tab.

---

### Additional Information

The issue consistently appears in the specified setup and browsers.
