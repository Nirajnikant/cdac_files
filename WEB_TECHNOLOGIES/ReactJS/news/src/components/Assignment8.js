const Assignment8 = () => {
    const employees = [
        {
            empid:1001,
            empname:"Michael Scott",
            sal:230000
        },
        {
            empid:1002,
            empname:"Jim Halpert",
            sal:260000
        },
        {
            empid:1003,
            empname:"Dwight Schrut",
            sal:270000
        },
        {
            empid:1004,
            empname:"Stanley Hudson",
            sal:210000
        }
    ]

    const updatedEmployees = employees.map(emp => {
        return (
            <tr>
                <td>{emp.empid}</td>
                <td>{emp.empname}</td>
                <td>{emp.sal}</td>
            </tr>
        )
    })

    return (
        <div>
        <table border="1">{updatedEmployees}</table>
        </div>
    )

}

export default Assignment8;