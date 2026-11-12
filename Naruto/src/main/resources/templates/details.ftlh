<import "layout.ftlh" as 1>
    <@1.page title="Character Details" active="home">


    <div class="container my-5">
        <div class="row">
            <div class="col-md-4">
                <img src="${character.imageUrl!'/images/placeholder.svg'}" class="img-fluid rounded shadow" alt="${character.name}">
            </div>
            <div class="col-md-8">
                <h2>${character.name}</h2>
                <p class="text-muted"><strong>Village:</strong> ${character.village!'Unknown'}</p>
                <p class="text-muted"><strong>Rank:</strong> ${character.rank!'Unknown'}</p>
                
                <hr>
                
                <h4>About / Backstory</h4>
                <p>${character.shortDescription!''}</p>

                <div class="mt-4">
                    <a href="/characters/${character.characterId?c}/edit" class="btn btn-warning me-2">Edit Character</a>
                    
                    <form action="/characters/${character.characterId?c}/delete" method="POST" class="d-inline" onsubmit="return confirm('Are you sure you want to delete ${character.name}?');">
                        <button type="submit" class="btn btn-danger">Delete Character</button>
                    </form>
                </div>

                <div class="mt-3">
                    <a href="/" class="btn btn-secondary">&larr; Back to Gallery</a>
                </div>
            </div>
        </div>
    </div>
</@l.page>