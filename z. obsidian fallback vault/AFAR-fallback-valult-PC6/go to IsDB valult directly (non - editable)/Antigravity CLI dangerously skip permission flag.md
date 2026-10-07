To skip all permission prompts when launching the Antigravity CLI (`agy`), you must use the explicit `--dangerously-skip-permissions` flag: [1, 2]

```bash
agy --dangerously-skip-permissions
```

## Key Details to Keep in Mind

- What it does: This activates the CLI's auto-approve ("YOLO") mode. It completely bypasses confirmation checks for all actions during that session, including writing files, executing terminal commands, and making network calls. [2, 3, 4]
- No short aliases: There is no short version (like `-y` or `--yolo`). The creators deliberately made the flag long and explicit so you cannot invoke it by accident or leave it hidden inside scripts. [2, 3]
- Interactive alternative: If you are already inside an active session and want to stop permission prompts without restarting, you can type `/permissions` or `/settings` to manually toggle your preset to Turbo mode or adjust auto-accept behavior. [1, 5, 6]

⚠️ Security Warning: As noted in the [Antigravity CLI Documentation](https://antigravity.google/docs/cli/modes/), it is highly recommended to only use this flag inside a secure, tightly scoped environment or a repository with clean, committed code so you can easily revert any accidental changes. [2, 3]

Would you like to know how to save this as a permanent setting in your `settings.json` file, or do you need help configuring a sandbox environment for extra safety?

  

[1] [https://antigravity.google](https://antigravity.google/docs/cli/using/)

[2] [https://www.aibuilderclub.com](https://www.aibuilderclub.com/blog/antigravity-cli-guide)

[3] [https://www.codeagentswarm.com](https://www.codeagentswarm.com/en/guides/antigravity-yolo-mode)

[4] [https://pushary.com](https://pushary.com/gemini-dangerously-skip-permissions)

[5] [https://discuss.ai.google.dev](https://discuss.ai.google.dev/t/help-how-to-enable-yolo-mode-or-similar-in-antigravity-cli/146209)

[6] [https://www.codeagentswarm.com](https://www.codeagentswarm.com/en/guides/how-to-use-antigravity-cli)