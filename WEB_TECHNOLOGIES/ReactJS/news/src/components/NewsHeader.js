import NewsContent from "./NewsContent";
import "./NewsHeader.css"

const NewsHeader = () => {
    const title = ["Kohli contradicts Ganguly: ‘I was never told not to give up T20 captaincy", 
    "IAF chopper crash: Group Captain Varun Singh succumbs to injuries",
    "India's Harnaaz Sandhu crowned Miss Universe"         
]
    return (
        <div class="row">
             
            <h1>NEWS IN BRIEF</h1>
            <div class="column">
                <div class="card">
                    <NewsContent titlehead = {title[0]} content = "Virat Kohli, captain of India’s red-ball side, addressed a virtual press conference from Mumbai ahead of the team’s departure to South Africa and put all rumours to rest. He also rubbished reports that he would be opting out of the ODI leg of the South Africa tour. India’s Test captain threw his weight behind the newly-appointed white-ball captain, Rohit Sharma." />
                </div>
            </div>  
            <div class="column">
                <div class="card">  
                    <NewsContent titlehead = {title[1]} content = "The Indian Air Force (IAF) Wednesday said Group Captain Varun Singh, the lone survivor in the IAF chopper crash in Tamil Nadu on December 8, had succumbed to injuries. The crash near Coonoor had killed India’s most senior military officer, Chief of Defence Staff Bipin Rawat, his wife Madhulika and 11 others." />
                </div>
            </div>
            <div class="column">
                <div class="card">  
                    <NewsContent titlehead = {title[2]} content="Harnaaz Sandhu Miss Universe 2021: India’s Harnaaz Sandhu is the Miss Universe 2021. She won the title 21 years after Lara Dutta won the crown in 2000. She was crowned by previously reigning Miss Universe Andrea Meza from Mexico. She won the title 21 years after Lara Dutta won the crown in 2000. She was crowned by previously reigning Miss Universe Andrea Meza. " />
                </div>
            </div>
        </div>
    );
}
export default NewsHeader;