// Call the dataTables jQuery plugin
    $(document).ready(function() {
        loadUsers();
      $('#table-users').DataTable();
    });
    async function loadUsers(){
        const request = await fetch('users',{
            method:'GET',
            headers:{
                'Accept':'Application/json',
                'Content-Type':'application/json'
            }
        });
        const users= await request.json();
        let listHtml="";
        for(let user of users){
            let deleteButton='<a onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a>'
            let userHtml=`<tr>
                <td>${user.id}</td>
                <td>${user.name} ${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td class="center-actions">
                    ${deleteButton}
                </td>
            </tr>`;
            listHtml+=userHtml;
        }

        document.querySelector("#table-users tbody").outerHTML=listHtml;

    }

    async function deleteUser(id){
        if(!confirm('do you want to delete this user?')){
            return ;
        }
        const request = await fetch('users/'+id,{
                                    method:'DELETE',
                                    headers:{
                                        'Accept':'Application/json',
                                        'Content-Type':'application/json'
                                    }
                                });


        location.reload();
    }