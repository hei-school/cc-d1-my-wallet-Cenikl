// Wallet object
const wallet = {
    cardStorage: [],
    idCardStorage: [],
    moneyStorage: 0,
    coinStorage: 0,
    keyHolder: [],
    isLocked: true,
  };
  
  function unlockWallet() {
    wallet.isLocked = false;
    console.log('Wallet locked!');
  }
  
  // Function to add a card to the wallet
  function addCard(card) {
    if (!wallet.isLocked) {
      wallet.cardStorage.push(card);
      console.log(`Card added: ${card}`);
    } else {
      console.log('Wallet is locked. Please unlock it first.');
    }
  }
  
  // Function to add an ID card to the wallet
  function addIdCard(idCard) {
    if (!wallet.isLocked) {
      wallet.idCardStorage.push(idCard);
      console.log(`ID Card added: ${idCard}`);
    } else {
      console.log('Wallet is locked. Please unlock it first.');
    }
  }
  
  // Function to add money to the wallet
  function addMoney(amount) {
    if (!wallet.isLocked) {
      wallet.moneyStorage += amount;
      console.log(`Added $${amount} to the wallet.`);
    } else {
      console.log('Wallet is locked. Please unlock it first.');
    }
  }
  
  // Function to add coins to the wallet
  function addCoins(count) {
    if (!wallet.isLocked) {
      wallet.coinStorage += count;
      console.log(`Added ${count} coins to the wallet.`);
    } else {
      console.log('Wallet is locked. Please unlock it first.');
    }
  }
  
  // Function to lock the wallet
  function lockWallet() {
    wallet.isLocked = true;
    console.log('Wallet locked!');
  }
  
  // Function to display wallet status
  function displayWalletStatus() {
    if(!wallet.isLocked){
    console.log('--- Wallet Status ---');
    console.log('Card Storage:', wallet.cardStorage);
    console.log('ID Card Storage:', wallet.idCardStorage);
    console.log('Money Storage:', wallet.moneyStorage);
    console.log('Coin Storage:', wallet.coinStorage);
    console.log('Is Locked:', wallet.isLocked ? 'Yes' : 'No');
    console.log('----------------------');
    } else{
        console.log('Wallet is locked. Please unlock it first.');
    }
  }
  
  // Function to process user commands
  function processCommand(command) {
    const [action, ...params] = command.split(' ');
  
    switch (action.toLowerCase()) {
      case 'unlock':
        unlockWallet();
        break;
      case 'addcard':
        addCard(params.join(' '));
        break;
      case 'addidcard':
        addIdCard(params.join(' '));
        break;
      case 'addmoney':
        addMoney(parseFloat(params[0]) || 0);
        break;
      case 'addcoins':
        addCoins(parseInt(params[0]) || 0);
        break;
      case 'lock':
        lockWallet();
        break;
      case 'status':
        displayWalletStatus();
        break;
      case 'exit':
        console.log('Exiting the wallet app. Goodbye!');
        process.exit();
      default:
        console.log('Invalid command. Please try again.');
    }
  }
  
  // Recursive function to keep prompting for commands
  function promptForCommand() {
    const readline = require('readline');
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout,
    });
    rl.question('Enter a command: ', (answer) => {
      processCommand(answer);
      rl.close();
      promptForCommand();
    });
  }
  
  // Start the wallet app
  console.log('--- Wallet App ---');
  console.log(`
  These are the available commands :
      unlock
      addcard
      addidcard
      addmoney
      addcoins
      lock
      status
      exit
  `);
  
  // Initial prompt
  promptForCommand();
  