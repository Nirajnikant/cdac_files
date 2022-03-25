const EmpRow = (prop) => {
    const updatedEmployees = prop.employee.map(emp => {
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
export default EmpRow