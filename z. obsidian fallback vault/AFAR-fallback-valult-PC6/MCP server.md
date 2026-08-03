An **MCP server** (Model Context Protocol server) is ==a lightweight program that acts as a universal bridge connecting AI models to external tools, databases, and file systems==. It lets AI applications safely request data and run actions without needing custom code for every single service. 

How It Works

- **Standard connector:** Works like a USB port for AI, creating a single plug-and-play standard instead of broken, custom integrations.

- **Core features:** Exposes **tools** (actions the AI can run), **resources** (files or data the AI can read), and **prompts** (reusable templates).

- **Communication:** Listens for commands from an AI client, performs the task on the local computer or a remote server, and sends back structured answers.