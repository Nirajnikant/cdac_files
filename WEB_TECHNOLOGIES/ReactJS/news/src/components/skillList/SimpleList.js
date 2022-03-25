const SimpleList = () => {
    const skills = ["NodeJS","ReactJS","Angular 10","MongoDB"]

    const skillsList = skills.map(skill => {
        return <li>{skill}</li>
    })

    return <ol>{skillsList}</ol>
}
export default SimpleList;