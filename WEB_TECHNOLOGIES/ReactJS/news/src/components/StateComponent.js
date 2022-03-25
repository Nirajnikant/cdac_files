import { useState } from "react";

const StateComponent =() => {
    const [uname, setUname] = useState('');
    const [sal, setSal] = useState(0);
    return (<h2>This is a component</h2>);
}

export default StateComponent;

