import os
import markdown

CONTENT_DIR = 'content'
OUTPUT_DIR = 'output'
TEMPLATE_FILE = 'template.html'

def load_template():
    with open(TEMPLATE_FILE, 'r', encoding='utf-8') as file:
        return file.read()

def convert_markdown_to_html(md_text):
    return markdown.markdown(md_text)

def build_site():
    template = load_template()
    
    if not os.path.exists(OUTPUT_DIR):
        os.makedirs(OUTPUT_DIR)

    for filename in os.listdir(CONTENT_DIR):
        if filename.endswith('.md'):
            filepath = os.path.join(CONTENT_DIR, filename)
            with open(filepath, 'r', encoding='utf-8') as file:
                md_content = file.read()
            
            html_content = convert_markdown_to_html(md_content)
            title = filename.replace('.md', '').capitalize()
            
            final_html = template.replace('{{ title }}', title).replace('{{ content }}', html_content)
            
            output_filename = filename.replace('.md', '.html')
            output_path = os.path.join(OUTPUT_DIR, output_filename)
            with open(output_path, 'w', encoding='utf-8') as output_file:
                output_file.write(final_html)
            
            print(f"Generated {output_filename}")

if __name__ == "__main__":
    build_site()
