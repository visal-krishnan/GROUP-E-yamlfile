// NewAssessmentForm.js
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './NewAssessment.css';

const NewAssessmentForm = () => {
    const [setname, setSetname] = useState('');
    const [domain, setDomain] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const newAssessment = { setname, domain };

        try {
            await axios.post('http://localhost:9098/assessments', newAssessment);
            navigate('/new-set'); // Redirect after successful submission
        } catch (error) {
            console.error('Error creating assessment:', error);
        }
    };

    return (
        <div className="mt-8">
            <div className="NewAssessmentForm">
                <h1>Create New Assessment</h1>
                <form onSubmit={handleSubmit}>
                    <label>
                        Set Name:
                        <input
                            type="text"
                            value={setname}
                            onChange={(e) => setSetname(e.target.value)}
                            required
                        />
                    </label>
                    <label>
                        Domain:
                        <input
                            type="text"
                            value={domain}
                            onChange={(e) => setDomain(e.target.value)}
                            required
                        />
                    </label>
                    <button type="submit">Create</button>
                </form>
            </div>
        </div>
    );
};

export default NewAssessmentForm;



