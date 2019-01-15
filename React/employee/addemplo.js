import React, { Component } from 'react';

import ListDepartment from "../depatment/listdeparment";

class AddEmp extends Component{

    

    data = {};

    state = {

        show : false

    }

    

    onClick = () => {

        this.setState({

            show : true

        });

    }

    

    onCancel = e => {

        e.preventDefault();

        this.setState({

            show : false

        });

    }

    

    add = e =>{

        e.preventDefault();

        //console.log("data",this.data);

        this.props.onEmpAdded(this.data);

        this.setState({

            show : false

        });

        this.data = {};

    }



    handleChange = event =>{

        console.log(event.target.value);

        this.data[event.target.id] = event.target.value;

    }

     adddata = (e) =>{

        console.log("In the add");

        e.preventDefault();

        var name=document.getElementById('name').value.length;

        //var l1=parseInt(name.length);

        var age=document.getElementById('age').value;

        var age1=parseInt(age);

        console.log(age, age1, name);

        if(age1>18 && name<20){

            

            this.setState({shown:false});

            this.props.onEmpAdded(this.data);

        }

        else{

            document.getElementById('error').innerHTML="error";

        }

    }





    render(){

        return (

            <div>

                <button onClick={this.onClick}>NEW EMPLOYEE</button>

                {this.state.show && (

                <div>

                    <form>

                        <label>NAME </label><input type="text" id="name" onChange={this.handleChange} /><br />

                        <label>LAST </label><input type="text" id="lname" onChange={this.handleChange} /><br />

                        <label>AGE </label><input type="number" id="age" onChange={this.handleChange} /><br />

                        <label>Designation </label><input type="text" id="designation" onChange={this.handleChange} /><br />

                        <label>Department </label><select id="department" onChange={this.handleChange}>

                        {

                this.props.departments && this.props.departments.map((department, i)=>{

                    return(

                    <option value={department.name}> 

                    {department.name}

                    </option>

                );

            })

        }

                        </select>

                      <br />

                        <label>LOCATION </label><input type="text" id="location" onChange={this.handleChange} /><br />

                        <button onClick={this.adddata}>ADD</button>

                        <button onClick={this.onCancel}>CANCEL</button>

                        <span id="error"></span>

                    </form>

                </div>

                    )}

            </div>

        );

    }

}



export default AddEmp;