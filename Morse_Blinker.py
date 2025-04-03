import time
import logging
import sys
from colorama import Fore, Back, Style, init

# Initialize colorama
init(autoreset=True)

if sys.platform == "win32":
    import ctypes

# Set up logging with colorized output
logging.basicConfig(level=logging.INFO, format='%(message)s')

# Function to toggle Caps Lock
def toggle_caps_lock():
    if sys.platform == "win32":
        ctypes.windll.user32.keybd_event(0x14, 0, 0, 0)  # Press Caps Lock
        ctypes.windll.user32.keybd_event(0x14, 0, 2, 0)  # Release Caps Lock
    else:
        logging.error(f"{Fore.RED}Caps Lock toggling is not supported on this platform.")

# Function to blink LED (Caps Lock)
def blink_led(symbol):
    duration = 0
    if symbol == '.':
        duration = 0.5  # 500ms for dot
    elif symbol == '-':
        duration = 1.5  # 1500ms for dash

    if duration > 0:
        blink_type = "dot" if symbol == '.' else "dash"
        logging.info(f"{Fore.LIGHTGREEN_EX}Blinking {blink_type}")
        toggle_caps_lock()
        time.sleep(duration)
        toggle_caps_lock()
        time.sleep(0.5)  # 500ms between symbols

# Morse code transmitter function
def transmit_morse_code(message):
    morse_code = {
        'A': '.-', 'B': '-...', 'C': '-.-.', 'D': '-..', 'E': '.', 'F': '..-.',
        'G': '--.', 'H': '....', 'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..',
        'M': '--', 'N': '-.', 'O': '---', 'P': '.--.', 'Q': '--.-', 'R': '.-.',
        'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--', 'X': '-..-',
        'Y': '-.--', 'Z': '--..', '0': '-----', '1': '.----', '2': '..---',
        '3': '...--', '4': '....-', '5': '.....', '6': '-....', '7': '--...',
        '8': '---..', '9': '----.', ' ': ' '
    }

    message = message.upper()
    for letter in message:
        code = morse_code.get(letter, '')
        logging.info(f"{Fore.LIGHTGREEN_EX}Transmitting letter '{letter}' as Morse '{code}'")
        for symbol in code:
            blink_led(symbol)
        time.sleep(1.5)  # 1500ms between letters

if __name__ == "__main__":
    try:
        # Apply a dark background to the terminal window
        print(Back.BLACK + Fore.LIGHTGREEN_EX + Style.BRIGHT)
        logging.info(f"{Fore.LIGHTGREEN_EX}Starting Morse code transmission...")
        transmit_morse_code("ROHAN CHOUDHARI")
        logging.info(f"{Fore.LIGHTGREEN_EX}Message transmission complete.")
    except Exception as e:
        logging.error(f"{Fore.RED}An error occurred: {str(e)}")
