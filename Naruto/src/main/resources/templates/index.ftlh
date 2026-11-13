<#import "layout.ftlh" as l>
    <@l.page title="Naruto Characters" active="home">


    <h1 class="mb-4">Naruto Characters</h1>
<!-- main body content -->
    
        <form action="/" method="GET" class="search-form mb-4">
            <div class="row g-3">
                <div class="col-md-5">
                    <label for="name" class="form-label">Character Name:</label>
                    <input type="text" id="name" name="name" class="form-control" value="${name!''}" placeholder="Search by name">
                </div>
            

                <div class="col-md-5">
                    <label for="village" class="form-label">Village:</label>
                    <input type="text" id="village" name="village" class="form-control" value="${selectedVillage!''}" placeholder="Filter by village">
                </div>

                <div class="col-md-2 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary w-100 me-2">Search</button>
                    <a href="/" class="btn btn-secondary">Reset</a>
                </div>
            </div>
        </form>

        <div class="card-grid">
            <#list characters as c>
                <div class="character-card">
                    <img src="${c.imageUrl!'/images/placeholder.svg'}" class="image-character" alt="${c.name}">
                    <h3>${c.name}</h3>
                    <p>${c.shortDescription!''}</p>
                    <a href="/characters/${c.id?c}" class="details-btn">More Details</a>
                </div>
            <#else>
                <p class="text-muted">No characters found matching your search criteria.</p>
            </#list>
        </div>

    

</@l.page> 