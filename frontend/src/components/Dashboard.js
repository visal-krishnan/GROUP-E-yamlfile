import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './Dashboard.css';

const Dashboard = () => {
    // State to hold the data fetched from the API
    const [data, setData] = useState([]);

    // useEffect hook to fetch data when the component mounts
    useEffect(() => {
        axios.get('http://localhost:8081/survey')  // Adjust the URL if needed
            .then(response => setData(response.data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div className="Dashboard">
           
            <table>
                <thead>
                    <tr>
                        <th>SRL No</th>
                        <th>Assessment ID</th>
                        <th>Requester</th>
                        <th>Company Name</th>
                        <th>Domain</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(row => (
                        <tr key={row.surveyid}> {/* Ensure this matches the actual field */}
                            <td>{row.surveyid}</td> {/* Assuming you want to display surveyid */}
                            <td>{row.setname}</td>
                            <td>{row.requester}</td>
                            <td>{row.cname}</td>
                            <td>{row.domain}</td>
                            <td>{row.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Dashboard;
