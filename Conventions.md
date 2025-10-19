**CODING CONVENTIONS:**  
PascalCase for class names, camelCase for method names.  
`ExampleClass` and `void exampleMethod(int val)`

Opening brackets and braces on same line.  
`ExampleMethod(int val) {
//code
}`

Member and field names should follow the Minecraft conventions.

Doxygen comments before method declarations. Example:  
/**
@brief One line brief summary of method.  
@details For a more expansive description.  
@param <name> <description> Document method parameters.  
@return <description> To describe return value of the method.  
*/

All custom items, blocks, tags, etc. should be added to the appropriate file under the "datagen" folder.  
For the `.json` files to be added, the `runData` configuration under `Gradle` must be ran.

**REPO CONVENTIONS:**  
**DO NOT** Directly push to `main` or `development`. Submit pull request to merge changes to either of these branches.  
Branch names should follow the camelCase naming convention.  
Branch names should include name or username of author and feature being included. Example:  
`dylan/alloyMachine` or `dwilliams2348/alloyMachine`  