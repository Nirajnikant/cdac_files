import { useState } from "react";

const NewNews = (props) => {

    const [inputHeader,setNewsHeader] = useState('');
    const [inputContent, setNewsContent] = useState('');

    const formHandler = (event) => {
        event.preventDefault();//to stop page from reloading due to submit action
        console.log("in submit handler")
        const newNews ={
            header:inputHeader,
            content:inputContent,
        }
        console.log(newNews)
        setNewsHeader('')
        setNewsContent('')

        props.onAddNews(newNews)
    }

    const onHeaderChange = (event) => {
        setNewsHeader(event.target.value)
    }

    const onContentChange = (event) => {
        setNewsContent(event.target.value)
    }

    return (
        <form onSubmit={formHandler}>
            <label>Enter New news Heading</label>
            <input value={inputHeader} onChange={onHeaderChange}/>
            <label>Enter New New content</label>
            <input value={inputContent} onChange={onContentChange}/>
            <br />
            <button type='submit'>Add News</button>
        </form>
    )
};

export default NewNews