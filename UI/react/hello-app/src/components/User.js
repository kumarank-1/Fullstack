import { useEffect, useState } from 'react';
import {Link} from 'react-router-dom';


function Users(){
    // const navigate = Navigate();
    //useSate hook used to save users response 
    const [users_data,setUsers]=useState([0]);
    const [updated_user_email,setUpdateEmail] = useState('');
    const [updated_user_pwd,setUpdatePassword] = useState('');
    useEffect(() =>{
       fetch("http://localhost:3000/users")
       .then(resp => resp.json())
       .then((resp)=>{
            console.log(resp);
            setUsers(resp);
       })
    },[]);


    const createUser = () => {
        fetch("http://localhost:3000/users",{
            method:"POST",
            headers: {'Content-Type':'application/json'},
            body:JSON.stringify({
                "email":updated_user_email,
                "password":updated_user_pwd
            })
        }).then(
            res => res.json()
        ).then(res => {
            alert("User Created Successfully");
        });
    }
    const updateUser =(id) => {
        // alert(id + " " + updated_user_email + " " + updated_user_pwd)
        fetch("http://localhost:3000/users/" + id,{
            method:"PUT",
            headers: {'Content-Type':'application/json'},
            body:JSON.stringify({
                "email":updated_user_email,
                "password":updated_user_pwd
            })
        }).then(
            res => res.json()
        ).then(res => {
            alert("User Updated Successfully");
        });
    }


    const deleteUser = (id) => {
        fetch("http://localhost:3000/users/" + id,{
            method:"DELETE",          
            
        }).then(
            res => res.json()
        ).then(res => {
            alert("User Deleted Successfully")         
           
        });
        // navigate("/home");
        
    }
    return(
        <>
        <h2>Listing Users: </h2>
        <Link to="/home">Home</Link>


                <div>
                    Email: <input type='text' onChange={(e) => setUpdateEmail(e.target.value)}/>
                    Password: <input type='text' onChange={(e) => setUpdatePassword(e.target.value)}/>
                    <input type='button' value='Add User' onClick={() => createUser()}/>
                </div>
                <table id="users-table">
                    <thead>
                        <tr> 
                            <th>Id</th>                           
                            <th>Email</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users_data.map((user) => (
                            <tr>
                                <td>{user.id}</td>
                                <td><input type='text' defaultValue={user.email} onChange={(e) => setUpdateEmail(e.target.value)}/></td>
                                <td><input type='text' defaultValue={user.password} onChange={(e) => setUpdatePassword(e.target.value)}/></td>
                                <td><button onClick={() => updateUser(user.id)}>Update</button></td>
                                <td><button onClick={() => deleteUser(user.id)}>Delete</button></td>
                            </tr>
                        ))}
                    </tbody>                   
                </table>


        </>
    )
}


export default Users