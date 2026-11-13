<#import "layout.ftlh" as l>
  <@l.page title="Error" active="home">
    <h1>Error</h1>
    <p>${errorMessage!'An error occurred.'} </p>
    <a href="/src/main/resources/templates/about.ftlh">Back to all characters</a>

  </@l.page>