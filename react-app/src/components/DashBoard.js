
import React, { useState , useEffect } from 'react';
import './DashBoard.css';
import axios from 'axios';
var sampleBonds = [];

const Dashboard = () => {
    const [selectedOption, setSelectedOption] = useState('All Maturities');
    const [bondList, setBondList] = useState(sampleBonds);
    const [searchText, setSearchText] = useState('');
    const [searchField, setSearchField] = useState('issuer'); // Default search field
    const [sortField, setSortField] = useState('maturityDate'); // Default sort field
    const [sortOrder, setSortOrder] = useState('asc'); // Default sort order
    const [maturityDateFrom, setMaturityDateFrom] = useState('');
    const [maturityDateTo, setMaturityDateTo] = useState('');
    const [selectedHeading, setSelectedHeading] = useState('All Maturities');

    useEffect(() => {
        fetchBonds(); // Fetch bonds when the component mounts
    }, []);

    const fetchBonds = async () => {
        try {
            const response = await axios.get('http://localhost:8080/getAllSecurities');
            sampleBonds = response.data;
            setBondList(response.data); // Populate bondList with fetched data
        } catch (error) {
            console.error('Error fetching bonds:', error);
        }
    };

    const handleOptionClick = (option) => {
        setSelectedOption(option);

        if (option === 'Upcoming Maturities') {
            const upcomingBonds = sampleBonds.filter(bond => new Date(bond.maturityDate) > new Date());
            setBondList(upcomingBonds);
        } else if (option === 'Recent Maturities') {
            const recentBonds = sampleBonds.filter(bond => new Date(bond.maturityDate) <= new Date());
            setBondList(recentBonds);
        } else if (option === 'All Maturities') {
            setBondList(sampleBonds);
        } else if (option === 'Pending Maturities') {
            const pendingBonds = sampleBonds.filter(bond => bond.status === 'Unpaid');
            setBondList(pendingBonds);
        }

        setSelectedHeading(option);
    };

    const handleSearchChange = (event) => {
        setSearchText(event.target.value);
    };

    const handleSearchFieldChange = (event) => {
        setSearchField(event.target.value);
    };

    const handleSearch = () => {
        let filteredBonds = [];

        if (selectedOption === 'Upcoming Maturities') {
            filteredBonds = bondList.filter(bond => new Date(bond.maturityDate) > new Date());
        } else if (selectedOption === 'Recent Maturities') {
            filteredBonds = bondList.filter(bond => new Date(bond.maturityDate) <= new Date());
        } else if (selectedOption === 'All Maturities') {
            filteredBonds = bondList;
        } else if (selectedOption === 'Pending Maturities') {
            filteredBonds = bondList.filter(bond => bond.status === 'Unpaid');
        }

        filteredBonds = filteredBonds.filter(bond => {
            const fieldValue = bond[searchField].toString().toLowerCase();
            return fieldValue.includes(searchText.toLowerCase());
        });

        setBondList(filteredBonds);
    };

    const handleSortChange = (event) => {
        const field = event.target.value;
        setSortField(field);
        sortBondList(field, sortOrder);
    };

    const handleSortOrderChange = (event) => {
        const order = event.target.value;
        setSortOrder(order);
        sortBondList(sortField, order);
    };

    const handleMaturityDateFromChange = (event) => {
        setMaturityDateFrom(event.target.value);
        filterByMaturityDateRange(event.target.value, maturityDateTo);
    };

    const handleMaturityDateToChange = (event) => {
        setMaturityDateTo(event.target.value);
        filterByMaturityDateRange(maturityDateFrom, event.target.value);
    };

    const filterByMaturityDateRange = (fromDate, toDate) => {
        if (fromDate && toDate) {
            const filteredBonds = sampleBonds.filter(bond => {
                const maturityDate = new Date(bond.maturityDate);
                return maturityDate >= new Date(fromDate) && maturityDate <= new Date(toDate);
            });
            setBondList(filteredBonds);
        }
    };

    const sortBondList = (field, order) => {
        const sortedBonds = [...bondList].sort((a, b) => {
            const valueA = a[field];
            const valueB = b[field];

            if (field === 'maturityDate') {
                return (order === 'asc' ? 1 : -1) * (new Date(valueA) - new Date(valueB));
            } else if (field === 'issueSize') {
                const sizeA = parseFloat(valueA.slice(1).replace(',', ''));
                const sizeB = parseFloat(valueB.slice(1).replace(',', ''));
                return (order === 'asc' ? 1 : -1) * (sizeA - sizeB);
            } else {
                return (order === 'asc' ? 1 : -1) * (valueA.localeCompare(valueB));
            }
        });

        setBondList(sortedBonds);
    };

    return (
        <div className="dashboard">
            <div className="navbar">
                <h1>Bond Tracker</h1>
                <div className="search-container">
                    <input
                        type="text"
                        placeholder="Search..."
                        value={searchText}
                        onChange={handleSearchChange}
                    />
                    <select value={searchField} onChange={handleSearchFieldChange}>
                        <option value="id">ID</option>
                        <option value="issuer">Issuer</option>
                        <option value="maturityDate">Maturity Date</option>
                        <option value="issueSize">Issue Size</option>
                        <option value="status">Status</option>
                    </select>
                    <button onClick={handleSearch}>Search</button>
                </div>
                <div className="sort-container">
                    <label>Sort By:</label>
                    <select value={sortField} onChange={handleSortChange}>
                        <option value="id">ID</option>
                        <option value="issuer">Issuer</option>
                        <option value="maturityDate">Maturity Date</option>
                        <option value="issueSize">Issue Size</option>
                        <option value="status">Status</option>
                    </select>
                    <label>Order:</label>
                    <select value={sortOrder} onChange={handleSortOrderChange}>
                        <option value="asc">Ascending</option>
                        <option value="desc">Descending</option>
                    </select>
                </div>
                {/* <div className="date-range-container">
                    <label>From:</label>
                    <input
                        type="date"
                        value={maturityDateFrom}
                        onChange={handleMaturityDateFromChange}
                    />
                    <label>To:</label>
                    <input
                        type="date"
                        value={maturityDateTo}
                        onChange={handleMaturityDateToChange}
                    />
                </div> */}
            </div>
            <div className="content">
                <div className="options">
                    <button onClick={() => handleOptionClick('All Maturities')}>All Maturities</button>
                    <button onClick={() => handleOptionClick('Pending Maturities')}>Pending Maturities</button>
                    <button onClick={() => handleOptionClick('Upcoming Maturities')}>Upcoming Maturities</button>
                    <button onClick={() => handleOptionClick('Recent Maturities')}>Recent Maturities</button>

                </div>
                <div className="selected-heading">
                    <h2>{selectedHeading}</h2>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>ISIN</th>
                            <th>Issuer</th>
                            <th>Maturity Date</th>
                            <th>Face Value (In Crores)</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {bondList.map(bond => (
                            <tr
                                key={bond.id}
                                className={
                                    (new Date(bond.maturityDate) <= new Date() && bond.status === 'Unpaid')
                                        ? 'red-row'
                                        : ''
                                }
                            >
                                <td>{bond.isin}</td>
                                <td>{bond.issuer}</td>
                                <td>{bond.maturityDate}</td>
                                <td>{bond.faceValue}</td>
                                <td>{bond.status}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Dashboard;

