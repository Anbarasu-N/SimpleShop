export default function ErrorMessage({message}){return message?<p role="alert" className="error">{typeof message==='string'?message:'Something went wrong. Please try again.'}</p>:null}
