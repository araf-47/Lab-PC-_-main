You can absolutely automate this in Obsidian! Because Obsidian doesn't have a native setting to automatically inject emojis into headers as you type, you have two excellent ways to handle this depending on how you want it to work.

Here are your best options:

## Option 1: The Automated Way (Using the _Linter_ Plugin)

If you want to just type a normal header (`# My Header`) and have Obsidian automatically add the matching number emoji when you save or run a command, the community plugin **Linter** is your best bet.

### How to set it up:

1. Go to **Settings** > **Community plugins** > Browse, and search for **Linter**.
    
2. Install and enable it.
    
3. Open the **Linter settings** and go to the **Markdown** section.
    
4. Look for settings related to **Header** or **File Structure**.
    
5. You can use Linter's custom regex replacements or its built-in header formatting to automatically prepend characters.


> 💡 **Tip:** You can set Linter to run automatically every time you save (`Ctrl + S` or `Cmd + S`), so your headers instantly get their emojis without you lifting a finger.

## Option 2: The Fast-Typing Way (Using _Text Expanders_)

If you want the emoji to appear _while_ you are actively typing, using a text expander snippet is incredibly efficient. You can do this inside Obsidian using the **Text Expander** or **Espanso** plugins, or via native OS tools.

### Using Obsidian Canvas/Templates

You can create a quick template using the core **Templates** plugin (or the community plugin **Templater**):

1. Create a note called `Header 1 Template`.
    
2. Inside it, just put: `# 1️⃣ {{title}}` (or just `# 1️⃣` ).
    
3. Set a hotkey to insert that template instantly.
    

### Using System-Wide Shortcuts (Highly Recommended)

If you want this to feel seamless, use your operating system's built-in text replacement:

- **Mac:** Go to _System Settings > Keyboard > Text Replacements_. Add a shortcut like `h1;` to replace with `# 1️⃣` .
    
- **Windows:** Use a free tool like **Beeftext** or **AutoHotkey**. An AutoHotkey script would look like this:
    
    AutoHotkey
    
    ```
    ::h1::# 1️⃣{Space}
    ```
    

## ✨ Option 3: The Aesthetic Way (CSS Snippets)

If you don't actually care about the emoji being in the _text_ of the file, but you just want it to **look** like there is an emoji in Live Preview/Reading mode, you can use a custom CSS snippet.

1. Go to **Settings** > **Appearance** > scroll down to **CSS snippets** > click the folder icon.
    
2. Create a new text file named `header-emojis.css`.
    
3. Paste the following code into it:


```css
/* Adds a 1️⃣ emoji before Heading 1 in reading/live-preview mode */
.markdown-rendered h1::before,
.cm-header-1::before {
    content: "1️⃣ ";
}

/* Adds a 2️⃣ emoji before Heading 2 */
.markdown-rendered h2::before,
.cm-header-2::before {
    content: "2️⃣ ";
}
```

4. Save the file, go back to Obsidian, hit the refresh button next to CSS Snippets, and toggle it on.

**Why this is cool:** Your actual file stays perfectly clean (`# Header 1`), but Obsidian displays it beautifully with the emoji automatically!

Which of these approaches sounds closest to what you are trying to achieve?

***

**Option 3 is a great choice**. It keeps your vault incredibly clean, avoids the overhead of third-party plugins, and ensures your markdown files remain standard and highly portable.

Here is the exact step-by-step guide to setting up your custom CSS snippet, along with an expanded stylesheet so you have emojis ready for headers 1 through 4.

### Step 1: Open your Snippets Folder

1. Open Obsidian and click the **Settings** gear icon in the bottom left.
    
2. Go to **Appearance**.
    
3. Scroll all the way to the bottom until you see the **CSS snippets** section.
    
4. Click the small **folder icon** (Open snippets folder) on the right. This will open a folder on your computer's file explorer.

### Step 2: Create the CSS File

1. Inside that folder, create a new text file.
    
2. Rename it to `header-emojis.css` (make sure to change the file extension from `.txt` to `.css`).
    
3. Open this file in any text editor (like Notepad or TextEdit) and paste the following code:



```CSS
/* Heading 1 */
.markdown-rendered h1::before,
.cm-header-1:not(.cm-formatting-header)::before {
    content: "1️⃣ ";
}

/* Heading 2 */
.markdown-rendered h2::before,
.cm-header-2:not(.cm-formatting-header)::before {
    content: "2️⃣ ";
}

/* Heading 3 */
.markdown-rendered h3::before,
.cm-header-3:not(.cm-formatting-header)::before {
    content: "3️⃣ ";
}

/* Heading 4 */
.markdown-rendered h4::before,
.cm-header-4:not(.cm-formatting-header)::before {
    content: "4️⃣ ";
}
```

4. Save and close the file.
    

### Step 3: Activate it in Obsidian

1. Go back to Obsidian's **Appearance** settings menu.
    
2. Click the **Refresh snippets** icon (the circular arrows next to the folder icon).
    
3. You will see `header-emojis` appear in the list. Toggle the switch next to it to **On**.
    

### How it works now:

Whenever you type a standard header like `# Introduction`, Obsidian will automatically display it as **1️⃣ Introduction** in both **Live Preview** and **Reading** modes. However, if you open the file in a raw text editor outside of Obsidian, it will still just say `# Introduction`, keeping your data perfectly clean!