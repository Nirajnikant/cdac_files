import "./NewsContent"
const NewsContent = (prop) => {
    return (
        <div>
            <h3>{prop.titlehead}</h3>
            <p>{prop.content}</p>
        </div>
    );
}

export default NewsContent;