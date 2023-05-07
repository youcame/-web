function logout(){
    window.location.href = "LogoutServlet"
}
function checkApproval(){
    window.location.href = "ApprovalServlet"
}

function back(){
    window.location.href="CourseShowServlet"
}

function passApproval(approvalId){
    window.location.href="ApprovalExamineServlet?approvalId="+approvalId+"&result=true"
}

function unpassApproval(approvalId){
    window.location.href = "ApprovalExamineServlet?approvalId=" + approvalId + "&result=false";
}

function undoApproval(approvalId){
    window.location.href = "ApprovalExamineServlet?approvalId=" + approvalId + "&result=Null"
}

function studentUndoApproval(approvalId){
    window.location.href = "StudentApprovalServlet?approvalId=" + approvalId + "&state=able"
}

function studentChooseApproval(approvalId){
    window.location.href = "StudentApprovalServlet?approvalId=" + approvalId + "&state=unapproved"
}

function showReason(reason) {
    console.log('reason:', reason);
    window.alert(reason);
}
function showCongratulation(){
    window.alert("绝绝子，恭喜您通过了审核喵~");
}

