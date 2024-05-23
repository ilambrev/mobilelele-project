window.addEventListener("load", app);

function app() {
    const modelSelect = document.querySelector('#model');
    const yearSelect = document.querySelector('#year');
    const textOption = yearSelect.querySelector('option');

    if (modelSelect.value !== '' && yearSelect.value === '') {
        populateYearsList();
    }

    modelSelect.addEventListener('change', populateYearsList);

    function populateYearsList() {
        yearSelect.replaceChildren();
        yearSelect.appendChild(textOption);

        if (modelSelect.value === '') {
            return;
        }

        let [startYear, endYear] = Array.from(modelSelect.querySelectorAll('option'))
            .filter(o => o.value === modelSelect.value)[0].getAttribute('data-start-end-year')
            .split('/');

        startYear = Number(startYear);
        endYear = endYear !== 'null' ? Number(endYear) : new Date().getFullYear();

        for (let i = endYear; i >= startYear; i--) {
            const option = document.createElement('option');
            option.value = `${i}`;
            option.textContent = `${i}`;
            yearSelect.appendChild(option);
        }
    }
}