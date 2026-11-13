<import "layout.ftlh" as 1>
    <@1.page title="Error" active="home"> 

    <div class="container my-5 text-center">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">Oops! Something went wrong.</h4>
            <p>${errorMessage!'An unexpected error occurred'}</p>
        </div>
        <a href="/src/main/resources/templates/index.ftlh" class="btn btn-primary mt-3">Return to Home</a>
    </div>
</@1.page>