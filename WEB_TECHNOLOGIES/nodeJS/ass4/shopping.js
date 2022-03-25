exports.calculateDiscount = pamt => {
    if(pamt < 2500) {
        console.log("Discount = 0 \n Total Amount = "+ pamt );
    }
    else if(pamt>2500 && pamt<5000) {
        var d = pamt*0.1
        console.log("Discount of 10% = "+d+"\nTotal Amount = "+ (pamt+d));
    }
    else if(pamt>=5000) {
        var d = pamt*0.
        console.log("Discount of 20% = "+d+"\nTotal Amount = "+ (pamt*d));
    }

}

exports.calculateGST = pamt => {
    gst = (18/100) * pamt;
    console.log("GST of 18% = "+gst+ "\nTotal Amount = "+ (pamt + gst));
}