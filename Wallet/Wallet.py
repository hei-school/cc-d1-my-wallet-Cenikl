wallet = {
    'cardStorage': [],
    'idCardStorage': [],
    'moneyStorage': 0,
    'coinStorage': 0,
    'keyHolder': [],
    'isLocked': True,
}

def unlock_wallet():
        wallet['isLocked'] = False
        print('Wallet unlocked!')

def add_card(card):
    if not wallet['isLocked']:
        wallet['cardStorage'].append(card)
        print(f'Card added: {card}')
    else:
        print('Wallet is locked. Please unlock it first.')

def add_id_card(id_card):
    if not wallet['isLocked']:
        wallet['idCardStorage'].append(id_card)
        print(f'ID Card added: {id_card}')
    else:
        print('Wallet is locked. Please unlock it first.')

def add_money(amount):
    if not wallet['isLocked']:
        wallet['moneyStorage'] += amount
        print(f'Added ${amount} to the wallet.')
    else:
        print('Wallet is locked. Please unlock it first.')

def add_coins(count):
    if not wallet['isLocked']:
        wallet['coinStorage'] += count
        print(f'Added {count} coins to the wallet.')
    else:
        print('Wallet is locked. Please unlock it first.')

def lock_wallet():
    wallet['isLocked'] = True
    print('Wallet locked!')

def display_wallet_status():
    if not wallet['isLocked']:
        print('--- Wallet Status ---')
        print('Card Storage:', wallet['cardStorage'])
        print('ID Card Storage:', wallet['idCardStorage'])
        print('Money Storage:', wallet['moneyStorage'])
        print('Coin Storage:', wallet['coinStorage'])
        print('Is Locked:', 'Yes' if wallet['isLocked'] else 'No')
        print('----------------------')
    else:
        print('Wallet is locked. Please unlock it first.')

def process_command(command):
    action, *params = command.split()

    if action.lower() == 'unlock':
        unlock_wallet()
    elif action.lower() == 'addcard':
        add_card(' '.join(params))
    elif action.lower() == 'addidcard':
        add_id_card(' '.join(params))
    elif action.lower() == 'addmoney':
        add_money(float(params[0]) if params else 0)
    elif action.lower() == 'addcoins':
        add_coins(int(params[0]) if params else 0)
    elif action.lower() == 'lock':
        lock_wallet()
    elif action.lower() == 'status':
        display_wallet_status()
    elif action.lower() == 'exit':
        print('Exiting the wallet app. Goodbye!')
        quit()
    else:
        print('Invalid command. Please try again.')

print('--- Wallet App ---')
print('''
These are the available commands :
      unlock
      addcard (cardname)
      addidcard (idcardname)
      addmoney (amount)
      addcoins (amount)
      lock
      status
      exit''')

while True:
    user_input = input('Enter a command: ')
    process_command(user_input)
