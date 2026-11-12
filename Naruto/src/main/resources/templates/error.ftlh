<import "layout.ftlh" as 1>
    <@1.page as layout title="error" active="home"> 

    <div class="container my-5 text-center">
        <div class="alert alert-danger" role="alert">
            <h4 class="alert-heading">Oops! Something went wrong.</h4>
            <p>${errorMessage!'An unexpected error occurred while processing your request.'}</p>
        </div>
        <a href="/" class="btn btn-primary mt-3">Return to Home</a>
    </div>

</@1.page>