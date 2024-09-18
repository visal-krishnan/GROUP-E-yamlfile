import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './CreateAssessment.css';

const CreateAssessment = () => {
    // State to hold the data fetched from the API
    const [data, setData] = useState([]);

    // useEffect hook to fetch data when the component mounts
    useEffect(() => {
        axios.get('http://localhost:9098/assessments')  // Adjust the URL if needed
            .then(response => setData(response.data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div className="mt-4">
        <div className="CreateAssessment ">
            
            <table>
                <thead>
                    <tr>
                        <th>SRL No</th>
                        <th>Set Name</th>
                        <th>Created By</th>
                        <th>Domain</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(row => (
                        <tr key={row.setid}> {/* Ensure this matches the actual field */}
                            <td>{row.setid}</td>
                            <td>{row.setname}</td>
                            <td>{row.createdby}</td>
                            <td>{row.domain}</td>
                            <td>{row.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            </div>
            <Link to="/new-assessment">
            <button type="button" class="flex flex-row text-white bg-gradient-to-r from-purple-500 via-purple-600 to-purple-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-purple-300 dark:focus:ring-purple-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mt-4 ">New Assessment</button>
            </Link>
        </div>

       
    );
};

export default CreateAssessment;
