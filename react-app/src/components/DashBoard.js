
import React, { useState } from 'react';
import './DashBoard.css';

const sampleBonds = [
    { id: 'INE093JA7LY0', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '07-08-2023', issueSize: '₹63.825', status: 'Unpaid' },
    { id: 'INE093JA7LR4', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '09-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
    { id: 'INE093JA7LQ6', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '08-08-2023', issueSize: '₹63.825', status: 'Paid' },
    { id: 'INE093JA7LV6', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '08-08-2023', issueSize: '₹63.825', status: 'Unpaid' },
    { id: 'INE093JA7LS2', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '08-08-2023', issueSize: '₹63.825', status: 'Paid' },
    { id: 'INE093JA7LW4', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '09-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
    { id: 'INE093JA7LU8', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '09-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
    { id: 'INE093JA7LX2', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '09-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
    { id: 'INE093JA7CB7', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '10-08-2023', issueSize: '₹9.20', status: 'Upcoming' },
    { id: 'INE093JA7LT0', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '10-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
    { id: 'INE177R07084', issuer: 'AVENDUS FINANCE PRIVATE LIMITED', maturityDate: '07-08-2023', issueSize: '₹97.00', status: 'Paid' },
    { id: 'INE051307788', issuer: 'CHEMMANUR CREDITS AND INVESTMENTS LIMITED', maturityDate: '07-08-2023', issueSize: '₹0.08', status: 'Paid' },
    { id: 'INE051307770', issuer: 'CHEMMANUR CREDITS AND INVESTMENTS LIMITED', maturityDate: '06-08-2023', issueSize: '₹0.275', status: 'Unpaid' },
    { id: 'INE939X07028', issuer: 'MANBA FINANCE LIMITED', maturityDate: '11-08-2023', issueSize: '₹10.00', status: 'Upcoming' },
    { id: 'IN8248U07086', issuer: '360 ONE PRIME LIMITED', maturityDate: '11-08-2023', issueSize: '₹0.00', status: 'Upcoming' },
    { id: 'INE248U07DH1', issuer: '360 ONE PRIME LIMITED', maturityDate: '08-08-2023', issueSize: '₹499.90', status: 'Unpaid' },
    { id: 'INE093JA7CD3', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '05-08-2023', issueSize: '₹19.00', status: 'Paid' },
    { id: 'INE823G07136', issuer: 'J.K.CEMENT LIMITED', maturityDate: '04-08-2023', issueSize: '₹12.00', status: 'Paid' },
    { id: 'INE302E07292', issuer: 'SAKTHI FINANCE LIMITED', maturityDate: '14-08-2023', issueSize: '₹7.935', status: 'Upcoming' },
    { id: 'INE302E07284', issuer: 'SAKTHI FINANCE LIMITED', maturityDate: '08-08-2023', issueSize: '₹1.415', status: 'Paid' },
    { id: 'INE093JA7AB1', issuer: 'ANAND RATHI GLOBAL FINANCE LIMITED', maturityDate: '16-08-2023', issueSize: '₹63.825', status: 'Upcoming' },
];

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
                            <th>ID</th>
                            <th>Issuer</th>
                            <th>Maturity Date</th>
                            <th>Issue Size (In Crores)</th>
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
                                <td>{bond.id}</td>
                                <td>{bond.issuer}</td>
                                <td>{bond.maturityDate}</td>
                                <td>{bond.issueSize}</td>
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

