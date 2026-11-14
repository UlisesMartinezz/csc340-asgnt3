<#import "layout.ftlh" as l>
    <@l.page title="${formTitle!''} ">



    <div class="container my-5" style="max-width: 600px;">
        <h2 class="mb-4">${formTitle!'Character Form'}</h2>

        <form action="${formAction}" method="POST" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="name" class="form-label">Character Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${character.name!''}" required>
            </div>


            <div class="mb-3">
                <label for="village" class="form-label">Village:</label>
                <select id="village" name="village" class="form-select">
                    <option value="">-- Select Village --</option>
                    <option value="KONOHAGAKURE" ${(character.village! == "KONOHAGAKURE")?string('selected', '')}>Konohagakure (Hidden Leaf)</option>
                    <option value="SUNAGAKURE" ${(character.village! == "SUNAGAKURE")?string('selected', '')}>Sunagakure (Hidden Sand)</option>
                    <option value="KUMOGAKURE" ${(character.village! == "KUMOGAKURE")?string('selected', '')}>Kumogakure (Hidden Cloud)</option>
                    <option value="IWAGAKURE" ${(character.village! == "IWAGAKURE")?string('selected', '')}>Iwagakure (Hidden Stone)</option>
                    <option value="KIRIGAKURE" ${(character.village! == "KIRIGAKURE")?string('selected', '')}>Kirigakure (Hidden Mist)</option>
                    <option value="OTHER" ${(character.village! == "OTHER")?string('selected', '')}>Other / Rogue</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="rank" class="form-label">Rank:</label>
                <input type="text" id="rank" name="rank" class="form-control" value="${character.rank!''}">
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Short Description / Backstory:</label>
                <textarea id="description" name="description" class="form-control" rows="4">${character.shortDescription!''}</textarea>
            </div>

            <div class="mb-3">
                <label for="imageUrl" class="form-label">Image URL:</label>
                <input type="text" id="imageUrl" name="imageUrl" class="form-control" value="${character.imageUrl!''}" placeholder="Paste web link or local path">
            </div>

           
            <button type="submit" class="btn btn-primary">Save Character</button>
            <a href="/" class="btn btn-secondary ms-2">Cancel</a>
        </form>
    </div>

    
 </@l.page> 