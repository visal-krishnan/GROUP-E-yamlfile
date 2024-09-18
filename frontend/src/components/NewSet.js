import React, { useEffect, useState } from 'react';
import axios from 'axios';

const NewSet = () => {
    const [data, setData] = useState([]);
    const [selectedOption, setSelectedOption] = useState('Select a set');
    const [isDropdownOpen, setIsDropdownOpen] = useState(false);
    const [filteredQuestions, setFilteredQuestions] = useState([]);
    const [newQuestion, setNewQuestion] = useState('');
    
    useEffect(() => {
        axios.get('http://localhost:9098/assessments')
            .then(response => setData(response.data))
            .catch(error => console.error('Error fetching data:', error));
    }, []);
    
    useEffect(() => {
        if (selectedOption !== 'Select a set') {
            const setData = data.find(item => item.setname === selectedOption);
            setFilteredQuestions(setData ? setData.questions || [] : []);
        } else {
            setFilteredQuestions([]);
        }
    }, [selectedOption, data]);

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };

    const handleSelect = (option) => {
        setSelectedOption(option);
        setIsDropdownOpen(false);
    };

    const handleAddQuestion = () => {
        const updatedData = data.map(set => {
            if (set.setname === selectedOption) {
                return {
                    ...set,
                    questions: [...(set.questions || []), { qid: Date.now(), qdetails: newQuestion }]
                };
            }
            return set;
        });
        setData(updatedData);
        setNewQuestion('');
    };

    return (
        <div className="NewSet">
            <div className="flex flex-row items-center font-semibold text-white text-base bg-cyan-700 rounded h-12 mt-8 px-4">
                <div className="ml-8">Set name:</div>
                <div className="relative ml-4">
                    <button
                        onClick={toggleDropdown}
                        className="px-4 py-1 bg-white text-gray-800 border border-gray-300 rounded"
                    >
                        {selectedOption}
                    </button>
                    {isDropdownOpen && (
                        <div className="absolute mt-1 w-48 bg-white border border-gray-300 rounded shadow-lg">
                            {data.length > 0 ? (
                                data.map((item) => (
                                    <button
                                        key={item.setname}
                                        onClick={() => handleSelect(item.setname)}
                                        className="block w-full px-4 py-2 text-gray-700 hover:bg-gray-100 text-left"
                                    >
                                        {item.setname}
                                    </button>
                                ))
                            ) : (
                                <p className="px-4 py-2 text-gray-700">No sets available</p>
                            )}
                        </div>
                    )}
                </div>
            </div>
            
            {selectedOption !== 'Select a set' && (
                <>
                    <div className="mt-8">
                        <input
                            type="text"
                            value={newQuestion}
                            onChange={(e) => setNewQuestion(e.target.value)}
                            placeholder="Enter new question"
                        />
                        <button onClick={handleAddQuestion}>Add Question</button>
                    </div>
                    <table className="mt-8">
                        <thead>
                            <tr>
                                <th>SRL No</th>
                                <th>Question</th>
                                <th>Explore and edit options</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredQuestions.map(row => (
                                <tr key={row.qid}>
                                    <td>{row.qid}</td>
                                    <td>{row.qdetails}</td>
                                    <td><button>Edit</button></td>
                                    <td><button>Delete</button></td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </>
            )}
        </div>
    );
};

export default NewSet;
