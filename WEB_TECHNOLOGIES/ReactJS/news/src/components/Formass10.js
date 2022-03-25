//Asignment 10

import { useState } from "react";
import DisplayName from './DisplayName'
const Formass10 = (props) => {
    const [inputFirst, setFirstName] = useState('')
    const [inputLast, setLastName] = useState('')
    const [fName, setName] = useState('')
    const submitHandler = (event) => {
        event.preventDefault();
        setName(`${inputFirst} ${inputLast}`)

        // console.log(fullName)
        setFirstName('')
        setLastName('')
        // setName(fullName)

        // props.onName(fullName)

    }

    const firstNameHandler = (event) => {
        setFirstName(event.target.value)
    }
    
    const lastNameHandler = (event) => {
        setLastName(event.target.value)
    }

    // const btnHandler = () => {
    //     consol.log(fullName)
    //     set
    // }

    return (
        <div>
            <form onSubmit={submitHandler}>  
            {/* <form> */}
                <label>First Name : </label>
                <input value ={inputFirst} onChange={firstNameHandler}/><br />
                <label>Last Name : </label>
                <input value={inputLast} onChange={lastNameHandler}/><br />
                <button type="submit" >Submit</button>
                
            </form>
            <h3>{fName}</h3>
        </div>

    )
}
export default Formass10